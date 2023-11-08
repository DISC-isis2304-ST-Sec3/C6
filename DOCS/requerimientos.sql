//requerimiento 1
SELECT
    h.id AS habitacion_id,
    s.nombre AS servicio,
    SUM(s.precio) AS dinero_recolectado
FROM
    habitaciones h
JOIN
    reservas r ON h.id = r.habitaciones_id
JOIN
    reservas_servicios rs ON r.id = rs.reservas_id
JOIN
    servicios s ON rs.servicios_id = s.id
WHERE
    r.fecha_entrada >= (SELECT CURRENT_DATE - 365 FROM dual)
GROUP BY
    h.id, s.nombre
ORDER BY
    h.id, s.nombre;

//requerimiento 2
SELECT s.nombre AS servicio, SUM(rs.cont_servicios) AS total_consumido
FROM reservas_servicios rs
INNER JOIN servicios s ON rs.servicios_id = s.id
INNER JOIN reservas r ON rs.reservas_id = r.id
WHERE r.fecha_entrada > TO_DATE('2021-01-01', 'YYYY-MM-DD') AND r.fecha_salida < TO_DATE('2021-12-31', 'YYYY-MM-DD')
GROUP BY s.nombre
ORDER BY total_consumido DESC
FETCH FIRST 20 ROWS ONLY;

//requerimiento 3
SELECT id, ROUND(cont_habitaciones * 100 / 15, 2) AS resultado_multiplicacion
FROM habitaciones;

//requerimiento 5
SELECT
    u.login AS usuario,
    p.nombre AS producto_nombre,
    rfs.fecha_consumo AS fecha_consumo,
    p.costo AS costo_producto
FROM
    usuarios u
JOIN
    reservas r ON u.id = r.Usuarios_id
JOIN
    reservas_servicios rfs ON r.id = rfs.reservas_id
JOIN
    servicios s ON rfs.servicios_id = s.id
JOIN
    servicios_productos sp ON s.id = sp.servicios_id
JOIN
    productos p ON sp.productos_id = p.id
WHERE
    u.login = 'johndoe' -- Un ejemplo de nombre de usuario
    AND r.fecha_entrada >= TO_DATE('2023-01-01', 'YYYY-MM-DD')
    AND r.fecha_salida <= TO_DATE('2023-12-31', 'YYYY-MM-DD');

//requerimiento 6

//primera parte
WITH OcupacionDiaria AS (
    SELECT
        fecha_entrada AS fecha_reserva,
        COUNT(DISTINCT habitaciones_id) AS habitaciones_ocupadas
    FROM
        reservas
    WHERE
        check_in = 1
        AND fecha_entrada BETWEEN (SELECT MIN(fecha_entrada) FROM reservas) AND (SELECT MAX(fecha_salida) FROM reservas)
    GROUP BY
        fecha_entrada
)
SELECT
    fecha_reserva,
    habitaciones_ocupadas
FROM
    OcupacionDiaria
ORDER BY
    habitaciones_ocupadas DESC
FETCH FIRST 50 ROWS ONLY;

//segunda parte 
WITH IngresosDiarios AS (
    SELECT
        fecha_consumo AS fecha,
        SUM(cont_servicios) AS total_ingresos
    FROM
        reservas_servicios
    GROUP BY
        fecha_consumo
)
SELECT
    fecha,
    total_ingresos
FROM
    IngresosDiarios
ORDER BY
    total_ingresos DESC;

//tercera parte
WITH OcupacionDiaria AS (
    SELECT
        fecha_entrada AS fecha_reserva,
        COUNT(DISTINCT habitaciones_id) AS habitaciones_ocupadas
    FROM
        reservas
    WHERE
        check_in = 1
        AND fecha_entrada BETWEEN (SELECT MIN(fecha_entrada) FROM reservas) AND (SELECT MAX(fecha_salida) FROM reservas)
    GROUP BY
        fecha_entrada
)
SELECT
    fecha_reserva,
    habitaciones_ocupadas
FROM
    OcupacionDiaria
ORDER BY
    habitaciones_ocupadas ASC
FETCH FIRST 50 ROWS ONLY;


//requerimiento 7 

WITH consumo AS (
    SELECT
        u.id AS usuario_id,
        u.login AS usuario_login,
        SUM(r.costo_total) AS total_consumido
    FROM
        usuarios u
    JOIN
        reservas r ON u.id = r.usuarios_id
    WHERE
        r.fecha_entrada >= TO_DATE(SYSDATE - 365, 'DD/MM/YYYY')
    GROUP BY
        u.id, u.login
    HAVING
        SUM(r.costo_total) > 15000000
), 
estadia AS (
    SELECT
        u.id AS usuario_id,
        u.login AS usuario_login,
        SUM(ABS(r.fecha_salida - r.fecha_entrada)) AS total_dias_estadia
    FROM
        usuarios u
    JOIN
        reservas r ON u.id = r.usuarios_id
    WHERE
        r.fecha_entrada >= TO_DATE(SYSDATE - 365, 'DD/MM/YYYY')
        AND r.fecha_entrada <= (SELECT CURRENT_DATE FROM dual)
    GROUP BY
        u.id, u.login
    HAVING
        SUM(ABS(r.fecha_salida - r.fecha_entrada)) >= 14
)
SELECT
    consumo.usuario_id,
    consumo.usuario_login,
    estadia.total_dias_estadia,
    consumo.total_consumido
FROM
    consumo
JOIN
    estadia ON consumo.usuario_id = estadia.usuario_id;

//requerimiento 8 

SELECT 
    s.nombre AS nombre_del_servicio, 
    COUNT(rs.reservas_id) AS cantidad_de_solicitudes
FROM 
    servicios s
LEFT JOIN 
    reservas_servicios rs ON s.id = rs.servicios_id
LEFT JOIN 
    reservas r ON rs.reservas_id = r.id
WHERE 
    r.fecha_entrada >= (SYSDATE - 365) -- Último año de operación
GROUP BY 
    s.nombre
HAVING 
    COUNT(rs.reservas_id) < 3
ORDER BY 
    cantidad_de_solicitudes;




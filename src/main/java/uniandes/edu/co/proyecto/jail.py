import random
from faker import Faker

# Crear un objeto Faker para generar datos ficticios
fake = Faker()

# Generar datos para las tablas
def generate_insert_statements():
    i=0
    
    for _ in range(500):
        # Generar sentencia SQL para insertar datos en la tabla 'hoteles'
        hoteles_insert = f"INSERT INTO hoteles (nombre, tipo, estrellas, id) VALUES ('{fake.company()}', '{fake.word()}', {random.randint(1, 5)}, {i});"
        print(hoteles_insert)
        i+=1

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'usuarios'
        usuarios_insert = f"INSERT INTO usuarios (id, login, contrasena, nombre, no_documento, tipo_usuario, hoteles_id) VALUES ({i}, '{fake.user_name()}', '{fake.word()}', '{fake.name()}', {random.randint(1000000, 9999999)}, '{fake.word()}', {random.randint(1, 400)});"
        print(usuarios_insert)
        i+=1
    
    i=0
    for _ in range(2000):
        # Generar sentencia SQL para insertar datos en la tabla 'planes_de_cosumo'
        planes_de_consumo_insert = f"INSERT INTO planes_de_cosumo (comida, bebida, id, nombre) VALUES ('{random.choice(['0', '1'])}', '{random.choice(['0', '1'])}', {i}, '{fake.word()}');"
        print(planes_de_consumo_insert)
        i+=1

    i=0
    for _ in range(20000):
        # Generar sentencia SQL para insertar datos en la tabla 'habitaciones'
        habitaciones_insert = f"INSERT INTO habitaciones (costo_noche, tipo_habitacion, id, hoteles_id, cont_habitaciones) VALUES ({random.randint(50, 300)}, '{random.choice(['Suite Presidencial', 'Suite', 'Doble', 'Sencilla', 'Familiar'])}', {i}, {random.randint(1, 500)}, {random.randint(0, 310)});"
        print(habitaciones_insert)
        i+=1

    i=0
    for _ in range(10000):  # Puedes ajustar el número de registros que deseas crear
        # Generar sentencia SQL para insertar datos en la tabla 'carachabitaciones'
        carachabitaciones_insert = f"INSERT INTO carachabitaciones (nombre, id) VALUES ('{fake.word()}', {i});"
        print(carachabitaciones_insert)
        i+=1

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'productos'
        productos_insert = f"INSERT INTO productos (nombre, id, costo, tipo) VALUES ('{fake.word()}', {i}, {random.randint(5, 50)}, '{fake.word()}');"
        print(productos_insert)
        i+=1

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'reservas'
        reservas_insert = f"INSERT INTO reservas (numero_personas, id, fecha_entrada, fecha_salida, costo_total, check_in, check_out, planes_de_cosumo_id, hoteles_id, Usuarios_id, habitaciones_id) VALUES ({random.randint(1, 5)}, {i}, TO_DATE('{fake.date_between(start_date='-300d', end_date='today')}', 'YYYY-MM-DD'), TO_DATE('{fake.date_between(start_date='today', end_date='+50d')}', 'YYYY-MM-DD'), {random.randint(100, 500)}, {random.choice([0, 1])}, {random.choice([0, 1])}, {random.randint(1, 1500)}, {random.randint(1, 400)}, {random.randint(1, 85000)}, {random.randint(1, 15000)});"
        print(reservas_insert)
        i+=1

    i=0
    for _ in range(5000):
        # Generar sentencia SQL para insertar datos en la tabla 'servicios'
        servicios_insert = f"INSERT INTO servicios (nombre, id, tipo_servicio, precio) VALUES ('{fake.word()}', {i}, '{fake.word()}', {random.randint(10, 100)});"
        print(servicios_insert)
        i+=1

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'caract_habitacion'
        caract_habitacion_insert = f"INSERT INTO caract_habitacion (carachabitaciones_id, habitaciones_id) VALUES ({random.randint(1, 10000)}, {random.randint(1, 15000)});"
        print(caract_habitacion_insert)

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'reservas_servicios'
        reservas_servicios_insert = f"INSERT INTO reservas_servicios (reservas_id, servicios_id, fecha_consumo, cont_servicios) VALUES ({random.randint(1, 30000)}, {random.randint(1, 5000)}, TO_DATE('{fake.date_between(start_date='-30d', end_date='today')}', 'YYYY-MM-DD'), {random.randint(1, 5)});"
        print(reservas_servicios_insert)

    i=0
    for _ in range(100000):
        # Generar sentencia SQL para insertar datos en la tabla 'servicios_productos'
        servicios_productos_insert = f"INSERT INTO servicios_productos (servicios_id, productos_id) VALUES ({random.randint(1, 5000)}, {random.randint(1, 50000)});"
        print(servicios_productos_insert)


    pass



def main():
    try:

        generate_insert_statements()
    except EOFError:

        pass
    
main()
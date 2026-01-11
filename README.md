# Fernanpop

<img width="420" height="68" alt="Gemini_Generated_Image_f67qm6f67qm6f67q" src="https://github.com/user-attachments/assets/25a8746a-75f7-4dd9-a9f1-9def31e43d90" />

---

## 📚 Índice

1.  [Resumen de la Aplicación](#1-resumen-de-la-aplicación)
2.  [Funcionamiento de la Aplicación](#2-funcionamiento-de-la-aplicación)
    * [Requisito Previo](#requisito-previo)
    * [Iniciar aplicación](#iniciar-aplicación)
    * [Modo MOCK (Prueba)](#modo-mock-prueba)
    * [Flujo de la Aplicación](#flujo-de-la-aplicación)
    * [Menú de Usuario](#menú-de-usuario)
3.  [Tarifas](#3-tarifas)
4.  [Créditos](#4-créditos)

---

## 1. Resumen de la Aplicación

**Fernanpop** es una plataforma de **compraventa de artículos de segunda mano**. Su objetivo principal es conectar a usuarios para facilitar transacciones seguras, rápidas y eficientes de bienes usados, **promoviendo la economía circular**.

---

## 2. Funcionamiento de la Aplicación

### Requisito Previo

**🚨 ¡IMPORTANTE!**

Para poder ejecutar la aplicación es necesario tener instalado el **Java SE Development Kit 25.0.1** o una versión más reciente.

* **Enlace de Descarga (Windows x64):**
    `https://download.oracle.com/java/25/latest/jdk-25_windows-x64_bin.exe`

### Iniciar aplicación

Para iniciar la aplicación debes:
* Descargar el archivo comprimido **Ejecutable.zip**
* Entrar en el archivo y arrastrar afuera la carpeta con el nombre **Ejecutable**
* Entrar en la carpeta y ejecutar FernanPop, puede que salgan alertas de seguridad pero no se preocupe el programa es seguro

### Modo MOCK (Prueba)

Al iniciar la aplicación, se te preguntará si deseas usar un **MOCK** (Datos de prueba).

<img width="420" height="68" alt="image" src="https://github.com/user-attachments/assets/0aed8d68-f3e9-48cc-945d-a54ca41295e7" />

* Un **MOCK** utiliza usuarios y objetos predefinidos para probar el funcionamiento de la aplicación sin afectar datos reales.
* Los datos del MOCK se **restablecen** cada vez que se inicia la aplicación.
* **Usuarios de Prueba:**
    * `Prueba1@`, `1234`, `Sujeto de pruebas`
    * `Prueba2@`, `1234`, `Sujeto de pruebas2`
    * **Objeto Creado:** Gafas de sol.



### Flujo de la Aplicación (Sin MOCK)

#### 1. Menú de Login

Al arrancar, aparece el menú principal:

<img width="648" height="185" alt="Captura de pantalla 2026-01-11 125236" src="https://github.com/user-attachments/assets/9846f80b-5344-4709-925b-e61049071ea5" />

#### 2. Registro de Usuario (Opción 2)

Si es tu primera vez, selecciona la opción **2. Registrarse**.
Se te solicitarán:

* **Correo Electrónico:** Debe incluir el símbolo `@`.
* **Clave (Contraseña)**
* **Nombre de Usuario**

> **Nota:** Si el correo ya están registrados por otro usuario, el sistema no permitirá el registro.

<img width="630" height="236" alt="image" src="https://github.com/user-attachments/assets/d0cebd33-4867-4014-9d57-3131d2c037fe" />

#### 3. Inicio de Sesión (Opción 1)

Una vez creado tu usuario, selecciona la opción **1. Iniciar Sesión**.

* Si el correo y la clave son correctos, recibirás un mensaje de bienvenida con tu nombre de usuario.
* Si alguno de los datos es incorrecto, se mostrará un mensaje de fallo.

<img width="633" height="271" alt="image" src="https://github.com/user-attachments/assets/c595063a-fb30-4c0e-931b-baa36aa0f515" />

### Menú de Usuario

Al iniciar sesión, se despliega el menú principal de usuario con **9 opciones disponibles**:

<img width="690" height="302" alt="image" src="https://github.com/user-attachments/assets/352c910d-1ffa-4ac7-8742-715107c7d9a6" />

| Opción | Descripción |
| :---: | :--- |
| **1** | **Ver Información de Usuario y Productos en Venta** (Muestra datos personales y objetos a la venta). |
| **2** | **Modificar Datos Personales** (Permite actualizar tu información). |
| **3** | **Ver Productos en Venta** (Lista solo los productos que has publicado). |
| **4** | **Quitar Producto de la Venta** (Permite retirar una publicación activa). |
| **5** | **Poner Producto a la Venta** (Publica un nuevo artículo). |
| **6** | **Ver y Comprar Productos** (Lista todos los artículos disponibles en la plataforma). |
| **7** | **Ver Histórico de Ventas** |
| **8** | **Ver Histórico de Compras** |
| **9** | **Cerrar Sesión** |

---

#### 1. Ver Información y Productos

Muestra tus datos personales y una lista de los artículos que tienes actualmente en venta.

<img width="694" height="515" alt="image" src="https://github.com/user-attachments/assets/33f0ca89-15c0-4132-990b-dd77a6d9b852" />

#### 2. Modificar Datos Personales

Permite cambiar la información asociada a tu cuenta.

> **Nota:** Si el nuevo dato es igual al antiguo se muestra un mensaje de error.

<img width="696" height="474" alt="image" src="https://github.com/user-attachments/assets/6b16b793-8592-4873-a97c-05ab5816d85a" />

#### 3. Ver Productos en Venta

Visualización de tus artículos activos.

* **Sin objetos:**
    <img width="686" height="328" alt="image" src="https://github.com/user-attachments/assets/238e6332-af8c-4220-9ba4-37441e26f687" />
* **Con objetos:**
    <img width="699" height="448" alt="image" src="https://github.com/user-attachments/assets/f2c4bec3-1c55-4d65-926e-63a85011369f" />

#### 4. Quitar Producto de la Venta

* Para eliminar un artículo, introduce el **número** que aparece a la izquierda del mismo.
* Para cancelar la acción, escribe `salir`.
    <img width="997" height="358" alt="image" src="https://github.com/user-attachments/assets/c03bf366-a6bb-4caa-8b13-f425e6f6a139" />

#### 5. Poner Producto a la Venta

Se te solicitará el **nombre**, una **descripción** y el **precio** del artículo.

<img width="785" height="370" alt="image" src="https://github.com/user-attachments/assets/9310367b-22b6-491f-95d8-75e4920ae96b" />

#### 6. Ver y Comprar Productos

Muestra el listado completo de productos disponibles para la venta.

<img width="812" height="409" alt="image" src="https://github.com/user-attachments/assets/8111eaf1-4245-4451-9fbd-a264e29eb9ff" />

* Para salir sin comprar, escribe `salir`.
* **Proceso de Compra:** Tras comprar, se te pedirá que escribas un **comentario** y **califiques** al vendedor y al producto (de 0 a 5).
    <img width="1011" height="657" alt="image" src="https://github.com/user-attachments/assets/d3f4d4ed-eff7-4fae-98de-6139d1d1fc45" />
* **Restricción:** No se permite comprar productos publicados por uno mismo.
    <img width="821" height="327" alt="image" src="https://github.com/user-attachments/assets/20a7efc2-63b7-46fa-a748-86c847dbb33e" />

#### 7 y 8. Históricos

* **Histórico de Ventas:**
    <img width="692" height="330" alt="image" src="https://github.com/user-attachments/assets/afde4e70-d863-4f22-aec3-d9cefdcafcce" />
* **Histórico de Compras:**
    <img width="689" height="448" alt="Captura de pantalla 2026-01-11 173406" src="https://github.com/user-attachments/assets/9a4d2d7b-d070-4c01-bbf9-8a439fdacf23" />

---

## 3. Tarifas

Fernanpop ofrece dos modelos de monetización para adaptarse a tus necesidades de venta:

| Plan | Tipo de Cobro | Descripción | Ideal Para |
| :--- | :--- | :--- | :--- |
| **Plan Básico (Mensualidad)** | **Cuota Fija Mensual** | Pagas 50€ independientemente del volumen de tus ventas. No se aplica comisión por transacción. | Vendedores con un volumen de ventas alto y constante. |
| **Plan Comisión** | **Comisión por Venta** | Se retiene un porcentaje (X%) dependiendo del precio final de cada artículo vendido. No hay cuota mensual. | Vendedores ocasionales o aquellos que están empezando. |

---

## 4. Créditos

**Proyecto realizado por:**

* Mario Ocaña Vílchez
* Raúl Liébana Anguita

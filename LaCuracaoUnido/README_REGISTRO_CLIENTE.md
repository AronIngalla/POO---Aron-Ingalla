# Registro de Cliente

Se agregó un módulo de registro de clientes manteniendo la estructura del proyecto:

- `Cliente.java`: modelo con ID, DNI, número y nombres.
- `ClienteRepository.java`: almacenamiento en memoria y generación de ID.
- `IClienteService.java`: contrato del servicio.
- `ClienteServiceImp.java`: implementación del servicio.
- `ClienteController.java`: validación, guardado, edición, eliminación y carga de la tabla.
- `main_cliente.fxml`: formulario y tabla.
- `AppContext.java`: registro de Repository, Service y Controller.
- `MainGuiController.java` / `maingui.fxml`: opción **Clientes** en el menú.

Validaciones:
- DNI: exactamente 8 dígitos.
- Número: exactamente 9 dígitos.
- Nombres: obligatorio.

Los datos se mantienen mientras la aplicación está ejecutándose porque el repositorio usa una lista en memoria, igual que el patrón actual del proyecto.

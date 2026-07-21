# Modelo de datos - Ventas

Diagrama del modulo de ventas (`com.nh.apirest.model`). Muestra clave compuesta
(`@EmbeddedId` + `@MapsId`), relaciones bidireccionales 1..N y 1..1, y enums
persistidos como texto.

## Diagrama entidad-relacion

```mermaid
erDiagram
    CLIENTE ||--o{ PEDIDO : "realiza"
    PEDIDO  ||--o{ DETALLE_PEDIDO : "contiene"
    PRODUCTO ||--o{ DETALLE_PEDIDO : "aparece en"
    PEDIDO  ||--|| PAGO : "se cobra con"

    CLIENTE {
        Long   id PK
        String nombre
        String email UK
    }

    PEDIDO {
        Long          id PK
        LocalDateTime fecha
        EstadoPedido  estado "enum STRING"
        Long          cliente_id FK
        Long          pago_id FK "UK - relacion 1..1"
    }

    DETALLE_PEDIDO {
        Long       pedido_id PK "FK - parte de la clave compuesta"
        Integer    producto_id PK "FK - parte de la clave compuesta"
        int        cantidad
        BigDecimal precioUnitario "precio historico"
    }

    PRODUCTO {
        Integer id PK
        String  nombre
        double  precio
        String  categoria
    }

    PAGO {
        Long          id PK
        MetodoPago    metodo "enum STRING"
        BigDecimal    monto
        LocalDateTime fechaPago
    }
```

## Relaciones de clases (como lo ve JPA)

```mermaid
classDiagram
    class Cliente {
        +Long id
        +String nombre
        +String email
        +List~Pedido~ pedidos
        +agregarPedido(Pedido)
    }

    class Pedido {
        +Long id
        +LocalDateTime fecha
        +EstadoPedido estado
        +Cliente cliente
        +List~DetallePedido~ detalles
        +Pago pago
        +getTotal() BigDecimal
    }

    class DetallePedido {
        +DetallePedidoId id
        +Pedido pedido
        +Producto producto
        +int cantidad
        +BigDecimal precioUnitario
        +getSubtotal() BigDecimal
    }

    class DetallePedidoId {
        +Long pedidoId
        +Integer productoId
    }

    class Pago {
        +Long id
        +MetodoPago metodo
        +BigDecimal monto
        +Pedido pedido
    }

    class Producto {
        +Integer id
        +String nombre
        +double precio
        +String categoria
    }

    Cliente "1" o-- "*" Pedido : mappedBy=cliente (bidireccional)
    Pedido "*" --> "1" Cliente : dueno FK cliente_id
    Pedido "1" o-- "*" DetallePedido : mappedBy=pedido (bidireccional)
    Pedido "1" --> "1" Pago : dueno FK pago_id
    DetallePedido "*" --> "1" Producto : @MapsId(productoId)
    DetallePedido "*" --> "1" Pedido : @MapsId(pedidoId)
    DetallePedido *-- DetallePedidoId : @EmbeddedId
```

## Puntos clave que ilustra el modelo

- **Clave compuesta**: `DetallePedido` usa `@EmbeddedId DetallePedidoId`
  (pedido_id + producto_id). Un producto no se repite como linea en el mismo
  pedido.
- **`@MapsId`**: reutiliza las FK (`pedido_id`, `producto_id`) como partes de la
  clave primaria, sin columnas duplicadas.
- **Bidireccional 1..N**: `Cliente` <-> `Pedido` y `Pedido` <-> `DetallePedido`.
  El lado dueno tiene la FK; el inverso usa `mappedBy`. Los helpers
  (`agregarPedido`, `agregarDetalle`) mantienen ambos lados sincronizados.
- **Bidireccional 1..1**: `Pedido` (dueno, FK `pago_id`) <-> `Pago` (`mappedBy`).
- **Tabla de union con atributos**: en vez de `@ManyToMany`, el detalle es una
  entidad porque lleva `cantidad` y `precioUnitario`.
- **Enums como texto**: `EstadoPedido` y `MetodoPago` con
  `@Enumerated(EnumType.STRING)`.
- **`BigDecimal` para dinero**: nunca `double` en montos, por el redondeo.

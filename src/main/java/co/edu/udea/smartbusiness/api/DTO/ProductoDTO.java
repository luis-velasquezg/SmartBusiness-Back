package co.edu.udea.smartbusiness.api.DTO;

public class ProductoDTO {
        private int codigo;
        private String nombre;
        private double precio;
        private double costo;
        private double iva;
        private int inventario;

        public ProductoDTO() {
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public double getCosto() {
            return costo;
        }

        public void setCosto(double costo) {
            this.costo = costo;
        }

        public double getIva() {
            return iva;
        }

        public void setIva(double iva) {
            this.iva = iva;
        }

        public int getInventario() {
            return inventario;
        }

        public void setInventario(int inventario) {
            this.inventario = inventario;
        }


    }

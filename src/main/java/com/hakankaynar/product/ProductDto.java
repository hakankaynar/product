package com.hakankaynar.product;


public class ProductDto {

    private String name;
    private String uuid;

    public ProductDto (Product product) {
        this();
        this.name = product.getName();
        this.uuid = product.getUuid();
    }

    public ProductDto () {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ProductDto {" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

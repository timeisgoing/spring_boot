package com.wgl.cn.ioc.ioc1;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-06-02 000219:42:45
 * #Version 1.0
 **/

public class Wheel {

    private String brand;
    private String specification ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}

package com.wgl.cn.枚举;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-16 001615:18:39
 * #Version 1.0
 **/

enum Direction {
    SOURTH("南方"), NORTH("北方"), WEST("西方"), EAST("东方");

    Direction(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

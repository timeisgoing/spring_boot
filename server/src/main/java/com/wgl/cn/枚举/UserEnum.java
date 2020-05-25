package com.wgl.cn.枚举;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-16 001615:08:04
 * #Version 1.0
 **/
enum UserEnum {
    HTTP_200(200, "请求成功"), HTTP_404(404, "请求不存在"), HTTP_500(500, "请求失败");
    private Integer code;
    private String name;

    UserEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

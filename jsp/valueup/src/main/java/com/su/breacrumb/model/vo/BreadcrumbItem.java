package com.su.breacrumb.model.vo;

/**
 * 브레드크럼 한 항목(단계)을 나타내는 VO 클래스
 * 예: "홈 > 고객센터 > 공지사항" 중 하나의 단계
 */
public class BreadcrumbItem {

    private String name; // 표시될 이름
    private String url;  // 클릭 시 이동할 주소 (마지막 단계면 null)

    public BreadcrumbItem() {}

    public BreadcrumbItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BreadcrumbItem [name=" + name + ", url=" + url + "]";
    }
}

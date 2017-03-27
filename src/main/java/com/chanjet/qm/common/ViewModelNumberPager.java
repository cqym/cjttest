package com.chanjet.qm.common;


import java.util.HashMap;
import java.util.Map;

import com.chanjet.qm.util.StringHelper;

/**
 */
public class ViewModelNumberPager {
    private int currentPage;

    private int pageSize;

    private boolean showPreviou;

    private boolean showNext;

    private int totalRecords;

    private int pageCount;

    private int startPage;

    private int endPage;

    private String path;

    private Map<String, Object> params;

    private static String datePattern = "yyyy-MM-dd";


    public ViewModelNumberPager(int currentPage, int pageSize, int totalRecords, String path, Map<String, Object> params) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.showPreviou = (currentPage > 1);
        this.showNext = (totalRecords > currentPage * pageSize);
        this.totalRecords = totalRecords;
        this.pageCount = (this.totalRecords / pageSize) + (this.totalRecords % pageSize == 0 ? 0 : 1);
        this.path = path;
        this.params = params==null ? new HashMap<String, Object>() : params;
        CalcPageNumber();
    }


    public ViewModelNumberPager setDatePattern(String pattern){
        this.datePattern = pattern;
        return this;
    }


    private void CalcPageNumber() {
        int startPoint = 1;
        int endPoint = 9;
        if (currentPage > 4) {
            startPoint = currentPage - 4;
            endPoint = currentPage + 4;
        }

        if (endPoint > pageCount) {
            startPoint = pageCount - 8;
            endPoint = pageCount;
        }

        if (startPoint < 1) {
            startPoint = 1;
        }

        startPage = startPoint;
        endPage = endPoint;

        if (endPage < startPage) {
            endPage = startPage;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isShowPreviou() {
        return showPreviou;
    }

    public void setShowPreviou(boolean showPreviou) {
        this.showPreviou = showPreviou;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPreviou() {
        return currentPage - 1;
    }

    public int getNext() {
        return currentPage + 1;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
//        <footer class="footer bg-white b-t">
//        <div class="row text-center-xs">
//        <div class="col-md-6 hidden-sm">
//        <p class="text-muted m-t"></p>
//        </div>
//        <div class="col-md-6 col-sm-12 text-right text-center-xs">
//        <ul class="pagination pagination-sm m-t-sm m-b-none">
//        <li><a href="#"><i class="fa fa-chevron-left"></i></a></li>
//        <li class="active"><a href="#">1</a></li>
//        <li><a href="#">2</a></li>
//        <li><a href="#">3</a></li>
//        <li><a href="#">4</a></li>
//        <li><a href="#">5</a></li>
//        <li><a href="#"><i class="fa fa-chevron-right"></i></a></li>
//        </ul>
//        </div>
//        </div>
//        </footer>





        StringBuffer sb = new StringBuffer("<footer class=\"footer bg-white b-t\">\n" +
                "        <div class=\"row text-center-xs\">\n" +
                "        <div class=\"col-md-6 hidden-sm\">\n" +
                "        <p class=\"text-muted m-t\"></p>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-6 col-sm-12 text-right text-center-xs\">\n" +
                "        <ul class=\"pagination pagination-sm m-t-sm m-b-none\">");


        if (isShowNext() || isShowPreviou()) {
//            sb.append("<div class=\"pagination pagination-centered\">").append("<ul>");
            //first page
//            if(getCurrentPage() != 1){
//                params.remove("page");
//                sb.append("<li>")
//                        .append("<a href=\"" + StringHelper.generateUrl(path, params, datePattern) + "\"><i class=\"fa fa-chevron-left\"></i></a>")
//                        .append("</li>");
//            }

            if (isShowPreviou()) {
                params.put("page", String.valueOf(getCurrentPage() - 1));
                sb.append("<li>")
                        .append("<a href=\"" + StringHelper.generateUrl(path, params, datePattern) + "\"><i class=\"fa fa-chevron-left\"></i></a>")
                        .append("</li>");
                params.remove("page");
            } else {
                sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-chevron-left\"></i></a></li>");
            }
            for (int p = getStartPage(); p <= getEndPage(); p++) {
                if (p == getCurrentPage()) {
                    sb.append("<li class=\"active\" ><a>" + p +"</a ></li >");
                }
                else {
                    params.put("page", String.valueOf(p));
                    sb.append("<li><a href=\"" + StringHelper.generateUrl(path, params, datePattern) + "\">" + p + "</a></li>");
                    params.remove("page");
                }
            }
            if (isShowNext()) {
                params.put("page", String.valueOf(getCurrentPage() + 1));
                sb.append("<li><a href=\""+ StringHelper.generateUrl(path, params, datePattern) + "\"><i class=\"fa fa-chevron-right\"></i></a></li>");
                params.remove("page");
            }
            else {
                sb.append("<li class=\"disabled\"><a href=\"#\"><i class=\"fa fa-chevron-right\"></i></a></li>");
            }

            //last page
//            if(getCurrentPage() != getPageCount()){
//                params.put("page", String.valueOf(getPageCount()));
//                sb.append("<li>")
//                        .append("<a href=\"" + StringHelper.generateUrl(path, params, datePattern) + "\">尾页</a>")
//                        .append("</li>");
//                params.remove("page");
//            }

            sb.append(" </ul>\n" +
                    "        </div>\n" +
                    "        </div>\n" +
                    "        </footer>");
        }
        return sb.toString();
    }
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
 <!--/. NAV TOP  -->
       
		
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="${path }/luwei/account/accountlist"><i class="fa fa-dashboard"></i> Account Management</a>
                    </li>
                    <li>
                        <a href="${path }/luwei/account/userlist"><i class="fa fa-desktop"></i>User Management</a>
                    </li>
					<li>
                        <a href="${path }/luwei/train/trainlist"><i class="fa fa-bar-chart-o"></i> Train Management</a>
                    </li>
                    <li>
                        <a href="${path }/luwei/site/sitelist"><i class="fa fa-qrcode"></i>Site Management</a>
                    </li>
                    
                    <li>
                        <a href=""><i class="fa fa-table"></i> Order Management</a>
                    </li>
                    <li>
                        <a href=""><i class="fa fa-edit"></i> Authority Management </a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li>
                </ul>

            </div>

open module view_runner
{
    requires view_service;
  //  requires environment_service;

    requires static lombok;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;
    requires spring.beans;
    requires org.apache.tomcat.embed.core;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires environment_service;

}
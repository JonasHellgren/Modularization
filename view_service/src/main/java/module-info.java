open module view_service
{
    exports viewservice.api;
    requires transitive domain;

    requires nd4j.api;
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

}
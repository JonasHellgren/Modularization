open module controller
{
    requires service;
    requires domain;
    requires spring.beans;
    requires spring.boot;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires org.apache.tomcat.embed.core;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
}
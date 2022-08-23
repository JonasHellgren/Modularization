module environment_service
{
  // exports environment_service.api;
  // exports test to junit;

   requires transitive  domain;

   requires java.logging;
   //requires lombok;

   requires spring.context;
   requires spring.boot.autoconfigure;
   requires spring.boot;
   requires spring.web;
   requires spring.beans;
   requires junit;

}
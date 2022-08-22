module domain
{
    exports domain.models;
    exports domain.settings;
    exports domain.utils;

    requires static lombok;
    requires junit;
   // requires  nd4j-native-api;
   requires nd4j.api;
  // requires nd4j.common;

    //requires nd4j.common;
   // requires java.desktop;
}
Fixade Error occurred during initialization of boot layer
genom Proj structure -> Proj settings -> modules
Tog bort all nd4j dep förutom behåller nd4j:protobuf  nd4j:nd4j-api    nd4j:jackson

            <exclusions>
                <exclusion>
                    <groupId>org.nd4j</groupId>
                    <artifactId>nd4j-native</artifactId>
                </exclusion>

                <exclusion>
                    <groupId>org.nd4j</groupId>
                    <artifactId>nd4j-common</artifactId>
                </exclusion>

                <exclusion>
                    <groupId>org.nd4j</groupId>
                    <artifactId>nd4j-guava</artifactId>
                </exclusion>
                
            </exclusions>
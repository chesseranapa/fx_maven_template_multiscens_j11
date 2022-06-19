заготовка для GUI с несколькими сценами и вызовом внешних окон

должна быть отдельно библиотека
к ней прописать путь при запуске jar файла например запуск в моей текущей конфигурации
java --module-path c:\java\fx\sdk17\lib --add-modules javafx.controls,javafx.fxml -jar target\fxmaven11-1.0-SNAPSHOT.jar
На самом деле, внутри jar файла всё похоже есть. Нужно понять как это использовать.
Когда встроенные файлы для fx удаляешь, запуск указанным способом проходит.
Можно удалить из pom блок:
<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.3.0</version>
                <executions>
                    <!-- Run shade goal on package phase -->
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <!-- add Main-Class to manifest file -->
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>ru.avevdokimov.fxmaven11.StartApplication</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
и запускать мавеном:
mvn clean javafx:run 
для этого оставлен другой блок в pom

Вообщем, запуск нужно ещё додумать

### Docs
- [Kotlin Server Side](https://kotlinlang.org/lp/server-side/) 

### Tools
- [Start Ktor](https://start.ktor.io/settings)

### Unpacking and Running the Project on Windows
This is the process to unpack, build and run the project from the command line on Windows. The descriptions below assume that:

You have created and downloaded a project called api-kotlin-ktor.
- This has been placed in a folder called myprojects in your home directory.
- Please alter the names and paths as required to match your own setup.

Create a folder called api-kotlin-ktor in the current directory and unpack the archive created by the Ktor Project Generator into that folder:
- ```mkdir api-kotlin-ktor```
- ```tar -xf api-kotlin-ktor.zip -C api-kotlin-ktor```

Change into the new directory and build and run the application:
- ```cd api-kotlin-ktor```
- ```.\gradlew.bat build```
- ```.\gradlew.bat run```
- ```./gradlew -t build -x test -i```
-  ```java -jar build\libs\com.api.kotlin.ktor-all.jar ```

The output from the final command should look like this:
```
api-kotlin-ktor> Task :run
2023-07-05 16:00:51.735 [main] INFO ktor.application - Autoreload is disabled because the development mode is off.
2023-07-05 16:00:51.966 [main] INFO ktor.application - Application started in 0.256 seconds.
2023-07-05 16:00:52.094 [DefaultDispatcher-worker-1] INFO ktor.application - Responding at http://127.0.0.1:8080
<==========---> 80% EXECUTING [31s]
api-kotlin-ktor> :run
```
This shows us that the application has started successfully and is running on the current machine. You can verify the project is running by opening a browser at the URL mentioned in the output http://127.0.0.1:8080.

Note that the command line is unresponsive because the underlying process is busy running the Ktor application. You can type ```CTRL-C``` to cancel the application.

### Exploring the project
In order to discuss the project layout we have expanded the structure in the Project View and selected the file settings-gradle.kts.

- You will see that the code to run your application lives in packages under src/main/kotlin. The default package is called com.example and contains a subpackage called plugins. Two files have been created within these packages, named [Application.kt](./src/main/kotlin/example/com/Application.kt) and [Routing.kt](./src/main/kotlin/example/com/plugins/Routing.kt).

- The name of the project is configured in [settings-gradle.kts](./settings.gradle.kts)

- Configuration files, and other kinds of content, live within the ```src/main/resources``` folder

### Changing the Default Port
In the Project View navigate to the src/main/kotlin folder and then into the single package that has been created for you. Open the [Application.kt](./src/main/kotlin/example/com/Application.kt) file. You should find code similar to the following:

```kts
fun main() {
    embeddedServer(
        Netty, 
        port = 8080, // This is the port on which Ktor is listening
        host = "0.0.0.0", 
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureRouting()
}
```

## Changing the Port via YAML
When creating a new project in the Ktor Project Generator there is an option to store configuration externally, within either a YAML or a HOCON file.

If you had chosen to store configuration externally, then this would be the code in Application.kt:

```kts
fun main(args: Array<String>): Unit =
io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
}
```
These would be the values stored in the configuration file (YAML version):

```yml
ktor:
    application:
        modules:
            - com.example.ApplicationKt.module
    deployment:
        port: 8080
```

In this case you do not need to alter any code to change the port number. Simply alter the value in the YAML or HOCON file and restart the application. The change can be verified in the same way as with Task 1 above.

### Adding a new HTTP Endpoint
Notice the call to configureRouting in the Application.kt file. Navigate to this function by using the [Go To Declaration shortcut](https://www.jetbrains.com/help/idea/navigating-through-the-source-code.html#go_to_declaration) or opening the file Routing.kt manually. This is the code you should see:

```kts
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
```
Insert the additional five lines of code shown below to create a new endpoint:

```kts
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        // Add the five lines below
        get("/test1") {
            val text = "<h1>Hello From Ktor</h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }
    }
}
```
In order to make use of ContentType the following import is required.

```kts
import io.ktor.http.*
```
Note that the /test1 URL can be whatever you like. Restart the application and request the new URL in the browser. The port number you should use will depend on whether you have attempted the first task. You should see the output displayed below:

### Configuring static content
Open the file Routing.kt, as in the previous task. Once again this should be the default content:

```kts
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
```

Add the following line to the routing section. For this task it does not matter whether or not you have inserted the content for the extra endpoint specified in task (2).

```kts
fun Application.configureRouting() {
    routing {
        // Add the line below
        staticResources("/content", "public")

        get("/") {
            call.respondText("Hello World!")
        }
    }
}
```

The following import is required:

```kts
import io.ktor.server.http.content.*
```

The meaning of this line is as follows:

- Invoking staticResources tells Ktor that we want our application to be able to provide standard website content, such as HTML and JavaScript files. Although this content may be executed within the browser, it is considered static from the server's point of view.
- The URL ```/content``` specifies the path that should be used to fetch this content.
- The path ```public``` is the name of the folder within which the static content will live. Ktor will look for this folder within the resources directory.

In order to start serving this static content:

- Right click on the src/main/resources folder within the project and create a directory called ```public```. - Note you could also have used the new items shortcut.
- Within this folder right-click (or use the shortcut) and create a web page called sample.html. Populate the page with some sample HTML tags.
- Restart the application.
- Go to ```http://localhost:8081/content/generator.html```

### Writing an integration test
Ktor provides support for creating integration tests, and the Project Generator creates a skeleton test file for you underneath src/test/kotlin. Assuming you have accepted the default settings the class will be called ApplicationTest and live in the package com.example.

- [Official Test Documentation](https://ktor.io/docs/server-testing.html#testing-ws)

Open the class and add the code below:

```kts
class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }

        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello World!", response.bodyAsText())
    }
}
```
The following imports are required:

```kts
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Assert.assertEquals
import org.junit.Test
```
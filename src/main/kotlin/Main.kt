import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread


fun main() {
    var socket: Socket? = null

    val host = "127.0.0.1"
    val host2 = "192.168.1.222"
    socket = Socket(host2, 4444)


    val file = File("/Users/priyanshug/Desktop/ClientSide/src/main/kotlin/dummy.pdf")

    // Get the size of the file
    val length = file.length()
    val bytes = ByteArray(16 * 1024)
    val `in`: InputStream = FileInputStream(file)
    val out = socket.getOutputStream()

    out.write("dummy.pdf".toByteArray())
    out.flush()

    var count: Int
    while ((`in`.read(bytes).also { count = it }) > 0) {
        out.write(bytes, 0, count)
    }

    out.close()
    `in`.close()
    socket.close()



    // Responding to the client
//        writer.println("Hello from the server!")
//
//        clientSocket.close()
//        println("Client disconnected: ${clientSocket.inetAddress.hostAddress}")
}
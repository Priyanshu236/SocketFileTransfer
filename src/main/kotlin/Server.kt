import java.io.*
import java.net.ServerSocket
import java.net.Socket


fun main() {


    var serverSocket = ServerSocket(4444)

    val socket = serverSocket.accept()


    val `in` = socket.getInputStream()



    val bytes = ByteArray(16 * 1024)

    //first command will be file name
    val fileNameBytes = ByteArray(1024)
    val fileNameLength = `in`.read(fileNameBytes)
    val fileName = String(fileNameBytes, 0, fileNameLength)

    print(fileName)
    val fileOut = FileOutputStream("/Users/priyanshug/Desktop/ClientSide/src/main/kotlin/"+fileName)

    var count: Int
    while ((`in`!!.read(bytes).also { count = it }) > 0) {
        fileOut.write(bytes, 0, count)
    }

}

package object_exp

import java.util.Objects
class  App:DownloadListener{
    override fun onDownloadStarted() {
        println("Download Started...")
    }

    override fun onDownloadComplete(file: String) {
        println("$file Downloaded.")
    }

    override fun onProgressUpdate(progress: Int) {
        println("$progress% Downloaded")
    }
}
fun main() {
    val downloadListener = App()
    val downloader = Downloader()
    downloader.downloadListener = downloadListener
    downloader.downloadFile("FileA.mkv")
}
package backend.basicfunc

import java.io.File

fun get_userdata_location(): String {
    val workingDir = File(".").canonicalPath
    return "$workingDir\\ImmersingClassData"
}
package main.utilidades

import java.io.File

fun loadFile(structureFileName: String): MutableList<MutableList<Char>> {
    val ubicacion = "parqueos/Parqueo1/$structureFileName.txt"
    val linesOfFile: MutableList<MutableList<Char>> = mutableListOf()
    File(ubicacion).forEachLine { linesOfFile.add(it.toMutableList()) }
    return linesOfFile
}

fun fileToString(structureFileName: String): MutableList<MutableList<String>> {
    val mapaNivel: MutableList<MutableList<String>> = mutableListOf()
    val mapStructure = loadFile(structureFileName)
    for (line in mapStructure) {
        val lineOfStrings = mutableListOf<String>()
        for (element in line) {
            lineOfStrings.add(element.toString())
        }
        mapaNivel.add(lineOfStrings)
    }

    return mapaNivel
}

fun acceptedFile(structureFileName: String): Boolean {
    val listaParqueos = mutableListOf<String>()
    val fileToProcess = fileToString(structureFileName)

    for (line in fileToProcess) {
        for (element in line) {
            if (element == "*") {
                continue
            } else if (element == " ") {
                continue
            } else {
                if (listaParqueos.contains(element)) {
                    return false
                }
                listaParqueos.add(element)
            }
        }
    }

    return true
}
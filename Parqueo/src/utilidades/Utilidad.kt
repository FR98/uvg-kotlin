package main.utilidades

import java.io.File

fun loadFile(structureFileName: String): MutableList<MutableList<Char>> {
    val ubicacion: String = "parqueos/Parqueo1/"+structureFileName +".txt"
    var linesOfFile: MutableList<MutableList<Char>> = mutableListOf()
    File(ubicacion).forEachLine { linesOfFile.add(it.toMutableList()) }
    return linesOfFile
}

fun fileToString(strucctureFileName: String): MutableList<MutableList<String>> {
    val mapaNivel: MutableList<MutableList<String>> = mutableListOf()
    val mapStructure = loadFile(strucctureFileName)
    for (line in mapStructure) {
        var lineOfStrings = mutableListOf<String>()
        for (element in line) {
            lineOfStrings.add(element.toString())
        }
        mapaNivel.add(lineOfStrings)
    }
    return mapaNivel
}

fun acceptedFile(strucctureFileName: String): Boolean {
    //val mapaAceptado: MutableList<MutableList<String>> = mutableListOf()
    val listaParqueos = mutableListOf<String>()
    val fileToProcess = fileToString(strucctureFileName)

    for (line in fileToProcess) {
        for (element in line) {
            if (element == "*") {
                continue
            } else if (element == " ") {
                continue
            } else {
                if (listaParqueos.contains(element)) {
                    return false
                } else {
                    listaParqueos.add(element)
                }
            }
        }
    }
    return true
}

fun leerMapa() {
    //TODO
}
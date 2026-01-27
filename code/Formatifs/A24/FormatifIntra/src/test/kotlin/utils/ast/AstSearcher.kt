package utils.ast

import kotlinx.ast.common.ast.Ast
import kotlinx.ast.common.ast.AstNode
import kotlinx.ast.common.ast.DefaultAstTerminal
import kotlinx.ast.common.ast.rawAstOrNull
import kotlinx.ast.common.klass.RawAst

fun astDescriptionSearcher(asts: List<Ast>, description: String, returnList: MutableList<AstNode>) {
    for (ast in asts) {
        astDescriptionSearcher(ast, description, returnList)
    }
}

fun astDescriptionSearcher(ast: Ast, description: String, returnList: MutableList<AstNode>) {
    if (ast is AstNode) {
        if (ast.description == description && !returnList.contains(ast)) {
            returnList.add(ast)
        }

        val rawAst: RawAst? = ast.rawAstOrNull()
        if (rawAst != null) {
            rawAstDescriptionSearcher(rawAst, description, returnList)
        }
        astDescriptionSearcher(ast.children, description, returnList)

    }
}

fun rawAstDescriptionSearcher(rawAst: RawAst, description: String, returnList: MutableList<AstNode>) {
    val ast: Ast = rawAst.ast
    if (ast is AstNode) {
        astDescriptionSearcher(ast.children, description, returnList)
    }
}

fun findFunction(ast: Ast, functionName: String): Ast? {
    val functionDeclarations: MutableList<AstNode> = mutableListOf()
    astDescriptionSearcher(ast, "functionDeclaration", functionDeclarations)

    for (functionDeclaration in functionDeclarations) {
        for (child in functionDeclaration.children) {
            if (child.description == "simpleIdentifier" && ((child as AstNode).children[0] as DefaultAstTerminal).text == functionName) {
                return functionDeclaration
            }
        }
    }

    return null
}
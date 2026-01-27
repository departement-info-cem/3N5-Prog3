package utils.ast

import kotlinx.ast.common.ast.Ast
import kotlinx.ast.common.ast.AstNode

fun allPropertyDeclarationsAreTyped(ast: Ast): Boolean {
    val propertyDeclarations: MutableList<AstNode> = mutableListOf()
    astDescriptionSearcher(ast, "propertyDeclaration", propertyDeclarations)

    for (property in propertyDeclarations) {
        if (!variableDeclarationIsTyped(property)) {
            return false
        }
    }
    return true
}

fun variableDeclarationIsTyped(astNode: AstNode): Boolean {
    val variableDeclarations: MutableList<AstNode> = mutableListOf()
    astDescriptionSearcher(astNode, "variableDeclaration", variableDeclarations)
    for(children in variableDeclarations[0].children) {
        if(children.description == "type") {
            return true
        }
    }
    return false
}

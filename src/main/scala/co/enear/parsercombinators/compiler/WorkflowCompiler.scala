package co.enear.parsercombinators.compiler

import co.enear.parsercombinators.lexer.WorkflowLexer
import co.enear.parsercombinators.parser.{WorkflowParser, WorkflowAST}

object WorkflowCompiler {
  def apply(code: String): Either[WorkflowCompilationError, WorkflowAST] = {
    for {
      tokens <- WorkflowLexer(code).right
      ast <- WorkflowParser(tokens).right
    } yield ast
  }
}

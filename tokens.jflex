import java_cup.runtime.*;

%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer

%{
    /**
     * Return a new Symbol with the given token id, and with the current line and
     * column numbers.
     */
    Symbol newSym(int tokenId) {
        return new Symbol(tokenId, yyline, yycolumn);
    }

    /**
     * Return a new Symbol with the given token id, the current line and column
     * numbers, and the given token value.  The value is used for tokens such as
     * identifiers and numbers.
     */
    Symbol newSym(int tokenId, Object value) {
        return new Symbol(tokenId, yyline, yycolumn, value);
    }
%}

/*-*
 * PATTERN DEFINITIONS:
 */

identifier = [A-Za-z][[A-Za-z][0-9]]*
integer_literal = [0-9]+
floating_point_literal = {integer_literal}\.[0-9]+
char_component = [^\\\n\t\"\']|\\.
character_literal = \'{char_component}\'
string = {char_component}*
string_literal = \"{string}\"

single_line_comment = \\\\.*(\n|\r|\r\n)
multi_line_comment = \\\*([^\*]|(\*+[^\\]))*?\*\\
whitespace = [ \n\t\r]



%%
/**
 * LEXICAL RULES:
 */

{whitespace}                { /* Ignore whitespace. */ }
{single_line_comment}       { /* Ignore single line comments */ }
{multi_line_comment}        { /* Ignore multi-line comments */ }

"int"                       { return newSym(sym.INTEGER_KEYWORD, "int"); }
"char"                      { return newSym(sym.CHARACTER_KEYWORD, "char"); }
"bool"                      { return newSym(sym.BOOLEAN_KEYWORD, "bool"); }
"float"                     { return newSym(sym.FLOAT_KEYWORD, "float"); }
"void"                      { return newSym(sym.VOID_KEYWORD, "void"); }
"if"                        { return newSym(sym.IF_KEYWORD, "if"); }
"else"                      { return newSym(sym.ELSE_KEYWORD, "else"); }
"while"                     { return newSym(sym.WHILE_KEYWORD, "while"); }
"read"                      { return newSym(sym.READ_KEYWORD, "read"); }
"print"                     { return newSym(sym.PRINT_KEYWORD, "print"); }
"printline"                 { return newSym(sym.PRINTLINE_KEYWORD, "printline"); }
"return"                    { return newSym(sym.RETURN_KEYWORD, "return"); }
"true"                      { return newSym(sym.TRUE_KEYWORD, "true"); }
"false"                     { return newSym(sym.FALSE_KEYWORD, "false"); }
"class"                     { return newSym(sym.CLASS_KEYWORD, "class"); }
"final"                     { return newSym(sym.FINAL_KEYWORD, "final"); }
{identifier}                { return newSym(sym.IDENTIFIER, yytext()); }
{integer_literal}           { return newSym(sym.INTEGER_LITERAL, Integer.valueOf(yytext())); }
{floating_point_literal}    { return newSym(sym.FLOATING_POINT_LITERAL, Double.valueOf(yytext())); }
{character_literal}         { return newSym(sym.CHARACTER_LITERAL, yytext().charAt(1)); }
{string_literal}            { return newSym(sym.STRING_LITERAL, yytext()); }

"="                         { return newSym(sym.EQUALS_OPERATOR, "="); }
"+"                         { return newSym(sym.PLUS_OPERATOR, "+"); }
"-"                         { return newSym(sym.MINUS_OPERATOR, "-"); }
"*"                         { return newSym(sym.MULTIPLICATION_OPERATOR, "*"); }
"/"                         { return newSym(sym.DIVISION_OPERATOR, "/"); }
"<"                         { return newSym(sym.LESS_THAN_OPERATOR, "<"); }
">"                         { return newSym(sym.GREATER_THAN_OPERATOR, ">"); }
"<="                        { return newSym(sym.LESS_THAN_OR_EQUAL_OPERATOR, "<="); }
">="                        { return newSym(sym.GREATER_THAN_OR_EQUAL_OPERATOR, ">="); }
"=="                        { return newSym(sym.EQUALITY_OPERATOR, "=="); }
"<>"                        { return newSym(sym.NOT_EQUAL_OPERATOR, "<>"); }
"||"                        { return newSym(sym.OR_OPERATOR, "||"); }
"&&"                        { return newSym(sym.AND_OPERATOR, "&&"); }
"~"                         { return newSym(sym.TILDE_OPERATOR, "~"); }
";"                         { return newSym(sym.SEMICOLON_DELIMITER, ";"); }
","                         { return newSym(sym.COMMA_DELIMITER, ","); }
"("                         { return newSym(sym.LEFT_PARENTHESIS, "("); }
")"                         { return newSym(sym.RIGHT_PARENTHESIS, ")"); }
"{"                         { return newSym(sym.LEFT_BRACKET, "{"); }
"}"                         { return newSym(sym.RIGHT_BRACKET, "}"); }
"["                         { return newSym(sym.LEFT_SQUARE_BRACKET, "["); }
"]"                         { return newSym(sym.RIGHT_SQUARE_BRACKET, "]"); }
":"                         { return newSym(sym.COLON_DELIMITER, ":"); }
"?"                         { return newSym(sym.QUESTION_MARK_OPERATOR, "?"); }
"++"                        { return newSym(sym.INCREMENT_OPERATOR, "++"); }
"--"                        { return newSym(sym.DECREMENT_OPERATOR, "--"); }

.                           { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yycolumn); }

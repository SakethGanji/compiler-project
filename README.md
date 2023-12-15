My Own Programming Language 
================
The grammar of my language:
```
Program → ClassDeclaration id { MemberDeclarations }

MemberDeclarations → FieldDeclarations MethodDeclarations

FieldDeclarations → FieldDeclaration FieldDeclarations | ε
MethodDeclarations → MethodDeclaration MethodDeclarations | ε

FieldDeclaration → OptionalFinal Keyword Type Identifier OptionalExpression ;
                 | Type Identifier [ IntegerLiteral ] ;

OptionalFinal → 'final' | ε

OptionalExpression → '= Expression' | ε

MethodDeclaration → ReturnType Identifier ( ArgumentDeclarations ) { FieldDeclarations Statements } OptionalSemicolon

OptionalSemicolon → ';' | ε

ReturnType → Type | 'void'

Type → 'int' | 'char' | 'bool' | 'float'

ArgumentDeclarations → ArgumentDeclarationList | ε
ArgumentDeclarationList → ArgumentDeclaration ',' ArgumentDeclarationList | ArgumentDeclaration

ArgumentDeclaration → Type Identifier | Type Identifier [ ]

Statements → Statement Statements | ε

Statement → 'if' ( Expression ) Statement ElsePart
           | 'while' ( Expression ) Statement
           | VariableName '=' Expression ';'
           | 'read' ( ReadList ) ';'
           | 'print' ( PrintList ) ';'
           | 'printline' ( PrintLineList ) ';'
           | Identifier ( ) ';'
           | Identifier ( Arguments ) ';'
           | 'return' ';'
           | 'return' Expression ';'
           | VariableName '++' ';'
           | VariableName '--' ';'
           | '{' FieldDeclarations Statements '}' OptionalSemicolon

ElsePart → 'else' Statement | ε

VariableName → Identifier | Identifier [ Expression ]

Arguments → Expression ',' Arguments | Expression

ReadList → VariableName ',' ReadList | VariableName

PrintList → Expression ',' PrintList | Expression

PrintLineList → PrintList | ε

Expression → VariableName
            | Identifier ( )
            | Identifier ( Arguments )
            | IntegerLiteral
            | CharacterLiteral
            | StringLiteral
            | FloatLiteral
            | 'true'
            | 'false'
            | '(' Expression ')'
            | '~' Expression
            | '-' Expression
            | '+' Expression
            | '(' Type ')' Expression
            | Expression BinaryOperator Expression
            | '(' Expression '?' Expression ':' Expression ')'

BinaryOperator → '*' | '/' | '+' | '-' | '<' | '>' | '<=' | '>=' | '==' | '<>' | '||' | '&&'

```
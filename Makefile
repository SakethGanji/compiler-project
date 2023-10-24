JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java parser.java sym.java\
        LexerTest.java ScannerTest.java Token.java Program.java BinaryExpr.java\
        NumExpr.java OperandExpr.java


default: run

run: part2phase1

part1: basicTest.txt basicFails.txt basicRegex.txt basicTerminals.txt my_testcases.txt

part2phase1: Phase1_expressions.txt Phase1_order_of_ops.txt Phase1_statements.txt

all: Lexer.java parser.java $(FILE:java=class)

basicTest.txt: all
		$(JAVA) -cp $(CP) LexerTest basicTest.txt > basicTest-output.txt
		@echo "==== Original File ===="
		cat basicTest.txt
		@echo "==== Output File ===="
		cat -n basicTest-output.txt

basicFails.txt: all
		$(JAVA) -cp $(CP) LexerTest basicFails.txt > basicFails-output.txt
		@echo "==== Original File ===="
		cat basicFails.txt
		@echo "==== Output File ===="
		cat -n basicFails-output.txt

basicRegex.txt: all
		$(JAVA) -cp $(CP) LexerTest basicRegex.txt > basicRegex-output.txt
		@echo "==== Original File ===="
		cat basicRegex.txt
		@echo "==== Output File ===="
		cat -n basicRegex-output.txt

basicTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest basicTerminals.txt > basicTerminals-output.txt
		@echo "==== Original File ===="
		cat basicTerminals.txt
		@echo "==== Output File ===="
		cat -n basicTerminals-output.txt

my_testcases.txt: all
		$(JAVA) -cp $(CP) LexerTest my_testcases.txt > my_testcases-output.txt
		@echo "==== Original File ===="
		cat my_testcases.txt
		@echo "==== Output File ===="
		cat -n my_testcases-output.txt

Phase1_expressions.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_expressions.txt > Phase1_expressions-output.txt
		@echo "==== Original File ===="
		@cat Phase1_expressions.txt
		@echo ""
		@echo "==== Output File ===="
		@cat -n Phase1_expressions-output.txt

Phase1_order_of_ops.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_order_of_ops.txt > Phase1_order_of_ops-output.txt
		@echo "==== Original File ===="
		cat Phase1_order_of_ops.txt
		@echo "==== Output File ===="
		cat -n Phase1_order_of_ops-output.txt

Phase1_statements.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase1_statements.txt > Phase1_statements-output.txt
		@echo "==== Original File ===="
		cat Phase1_statements.txt
		@echo "==== Output File ===="
		cat -n Phase1_statements-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup

# Individual run targets for convenience
run_basicTest: basicTest.txt

run_basicFails: basicFails.txt

run_basicRegex: basicRegex.txt

run_basicTerminals: basicTerminals.txt

run_my_testcases: my_testcases.txt

run_Phase1_expressions: Phase1_expressions.txt

run_Phase1_order_of_ops: Phase1_order_of_ops.txt

run_Phase1_statements: Phase1_statements.txt
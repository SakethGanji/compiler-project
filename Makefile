# =====================
# Definitions
# =====================

JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

.SUFFIXES: $(SUFFIXES) .class .java

FILE = Lexer.java parser.java sym.java LexerTest.java ScannerTest.java

.PHONY: default run part1 part2phase1 clean

# ===============
# Build Rules
# ===============

.java.class:
	$(JAVAC) -cp $(CP) $*.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup

all: Lexer.java parser.java $(FILE:java=class)

default: run

run: part1 part2phase1

# ====================
# Testing
# ====================

# Java classes for testing
P1_CLASS    = LexerTest
P2P1_CLASS  = ScannerTest
# Directories containing test cases
P1_DIR      = TestCases/part1/
P2P1_DIR    = TestCases/part2phase1/
# List of test case names
P1_TESTS    = basicTest basicFails basicRegex basicTerminals my_testcases
P2_P1_TESTS = Phase1_expressions Phase1_order_of_ops Phase1_statements

# individual part tests
part1: $(addprefix $(P1_DIR), $(addsuffix .txt, $(P1_TESTS)))
part2phase1: $(addprefix $(P2P1_DIR), $(addsuffix .txt, $(P2_P1_TESTS)))

# Generate dependencies for test cases
$(foreach test,$(P1_TESTS),$(eval $(test): $(P1_DIR)$(test).txt))
$(foreach test,$(P2_P1_TESTS),$(eval $(test): $(P2P1_DIR)$(test).txt))

# Rule for Part 1 test cases
TestCases/part1/%.txt: all
	$(JAVA) -cp $(CP) $(P1_CLASS) $@ > $(P1_DIR)/$*-output.txt
	$(call ECHO_AND_OUTPUT,$@,$(P1_DIR)/$*-output.txt)

# Rule for Part 2 Phase 1 test cases
TestCases/part2phase1/%.txt: all
	$(JAVA) -cp $(CP) $(P2P1_CLASS) $@ > $(P2P1_DIR)/$*-output.txt
	$(call ECHO_AND_OUTPUT,$@,$(P2P1_DIR)/$*-output.txt)

# ====================
# Utility Functions
# ====================

define ECHO_AND_OUTPUT
	@echo
	@echo "==== Original File ===="
	cat $1
	@echo
	@echo "==== Output File ===="
	cat -n $2
endef

# ==========
# Clean Up
# ==========

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

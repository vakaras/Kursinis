TEXINPUTS := .:./config:./common:./deps:./content:./examples:
export TEXINPUTS
PATH := deps/dot2tex/bin:${PATH}
export PATH
DOC_VERSION_HASH=$(shell git log -1 --pretty=format:"%H")
DOC_VERSION_TIME=$(shell git log -1 --pretty=format:"%ai")
XELATEX_JOB_NAME=document
XELATEX_OUTPUT_DIR=dist
XARG1=\newcommand{\docVersionHash}{${DOC_VERSION_HASH}}
XARG2=\newcommand{\docVersionTime}{${DOC_VERSION_TIME}}
XARG3=\input{$*.tex}
XELATEX_ARGS=-shell-escape \
						 -output-directory=${XELATEX_OUTPUT_DIR} \
						 -jobname=${XELATEX_JOB_NAME} \
						 "${XARG1}${XARG2}${XARG3}"
XELATEX_COMMAND=xelatex ${XELATEX_ARGS}

all: config/main.pdf

%.pdf: %.tex
	echo ${TEXINPUTS} ${PATH}
	$(XELATEX_COMMAND)
	bibtex "${XELATEX_OUTPUT_DIR}/${XELATEX_JOB_NAME}"
	$(XELATEX_COMMAND)

show:
	xdg-open "${XELATEX_OUTPUT_DIR}/${XELATEX_JOB_NAME}.pdf" 2> /dev/null

clean:
	rm -f dist/document.* dist/*.tmp

test:
	scala -cp code/KursinisScala/bin \
		lt.astrauskas.kursinis.e13.Demo \
		dist/document.interpreter.*.scala

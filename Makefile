TEXINPUTS := .:./config:./common:./deps:./content:./examples:
export TEXINPUTS
PATH := deps/dot2tex/bin:${PATH}
export PATH
XELATEX_JOB_NAME=document
XELATEX_OUTPUT_DIR=dist
XELATEX_ARGS=-shell-escape \
						 -output-directory ${XELATEX_OUTPUT_DIR} \
						 --job-name=${XELATEX_JOB_NAME} \
						 "\input{$*.tex}"
XELATEX_COMMAND=xelatex ${XELATEX_ARGS}

all: config/main.pdf

%.pdf: %.tex
	echo ${TEXINPUTS} ${PATH}
	$(XELATEX_COMMAND)
	bibtex dist/main
	$(XELATEX_COMMAND)

show:
	xdg-open "${XELATEX_OUTPUT_DIR}/${XELATEX_OUTPUT_DIR}.pdf"

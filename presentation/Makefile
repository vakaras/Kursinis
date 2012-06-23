DOC_VERSION_HASH=$(shell git log -1 --pretty=format:"%H")
DOC_VERSION_TIME=$(shell git log -1 --pretty=format:"%ai")
XELATEX_JOB_NAME=slides
XELATEX_OUTPUT_DIR=dist
MAIN_FILE=slides.tex
XELATEX_ARGS=-shell-escape \
						 -output-directory=${XELATEX_OUTPUT_DIR} \
						 -jobname=${XELATEX_JOB_NAME} \
						 ${MAIN_FILE}
XELATEX_COMMAND=xelatex ${XELATEX_ARGS}

all: prepare dist/slides.pdf

dist/slides.pdf: ${MAIN_FILE}
	echo ${TEXINPUTS}
	$(XELATEX_COMMAND)

show:
	xdg-open "${XELATEX_OUTPUT_DIR}/${XELATEX_JOB_NAME}.pdf" 2> /dev/null

clean:
	rm -f ${XELATEX_OUTPUT_DIR}/${XELATEX_JOB_NAME}*

DIST_DIR_EXISTS := $(wildcard dist)

ifeq ($(strip $(DIST_DIR_EXISTS)),)
prepare:
	@echo "Ruošiama aplinka."
	mkdir dist
else
prepare:
	@echo "Aplinka jau paruošta"
endif

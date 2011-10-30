TEXINPUTS := .:./config:./common:./deps:./content:./examples:
export TEXINPUTS

all: config/main.pdf

%.pdf: %.tex
	echo ${TEXINPUTS} ${PATH}
	xelatex -shell-escape -output-directory dist "\input{$*.tex}"
	bibtex dist/main
	xelatex -shell-escape -output-directory dist "\input{$*.tex}"

show:
	xdg-open dist/main.pdf

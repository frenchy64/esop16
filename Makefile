fast:
	pdflatex -shell-escape small.tex 


all:
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	pdflatex -shell-escape small.tex 
	pdftk small.pdf cat 1-12 output typed-clojure-draft.pdf

test:
	cd code/demo/ && ../../bin/lein test

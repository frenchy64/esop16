fast:
	pdflatex -shell-escape small.tex 


all:
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	pdftk small.pdf cat 1-13 output typed-clojure-draft.pdf
	pdftk small.pdf cat 14-end output typed-clojure-supplemental.pdf

test:
	cd code/demo/ && ../../bin/lein test

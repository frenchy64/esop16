all:
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	pdftk small.pdf cat 1-26 output typed-clojure-draft.pdf
	pdftk small.pdf cat 26-end output typed-clojure-supplemental.pdf

fast:
	pdflatex -shell-escape small.tex 

test:
	cd code/demo/ && ../../bin/lein test

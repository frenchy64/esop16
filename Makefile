all:
	pdflatex -shell-escape small.tex 
	bibtex small
	pdflatex -shell-escape small.tex 
	pdflatex -shell-escape small.tex 

test:
	cd code/demo/ && ../../bin/lein test

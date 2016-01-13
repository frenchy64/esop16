all:
	pdflatex small.tex 
	bibtex small
	pdflatex small.tex 
	bibtex small
	pdflatex small.tex 

fast:
	pdflatex small.tex 

test:
	cd code/demo/ && ../../bin/lein test

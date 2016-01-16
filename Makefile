all:
	pdflatex small.tex 
	bibtex small
	pdflatex small.tex 
	bibtex small
	pdflatex small.tex 

appendix:
	pdflatex with-appendix.tex 
	bibtex with-appendix
	pdflatex with-appendix.tex 
	bibtex with-appendix
	pdflatex with-appendix.tex 

fast:
	pdflatex small.tex 

test:
	cd code/demo/ && ../../bin/lein test

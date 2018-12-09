all:
	pdflatex with-appendix.tex 
	bibtex with-appendix
	pdflatex with-appendix.tex 
	bibtex with-appendix
	pdflatex with-appendix.tex 

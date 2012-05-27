SRCDIR := src/lt/astrauskas/kursinis
DESTDIR := bin
SRCFILES := $(shell find $(SRCDIR) -type f -name "*.scala")

SRCFILES_e9 := $(shell find $(SRCDIR)/e9 -type f -name "*.scala")
e9: ${SRCFILES_e9}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES_e9)
	scala -cp bin lt.astrauskas.kursinis.e9.Demo

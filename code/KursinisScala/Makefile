SRCDIR := src/lt/astrauskas/kursinis
DESTDIR := bin

SRCFILES := $(shell find $(SRCDIR) -type f -name "*.scala")
all: ${SRCFILES}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES)

SRCFILES_e9 := $(shell find $(SRCDIR)/e9 -type f -name "*.scala")
e9: ${SRCFILES_e9}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES_e9)
	scala -cp bin lt.astrauskas.kursinis.e9.Demo

SRCFILES_e10 := $(shell find $(SRCDIR)/e10 -type f -name "*.scala")
e10: ${SRCFILES_e10}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES_e10)
	scala -cp bin lt.astrauskas.kursinis.e10.Demo

SRCFILES_e12 := $(shell find $(SRCDIR)/e12 -type f -name "*.scala")
e12: ${SRCFILES_e12}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES_e12)
	scala -cp bin lt.astrauskas.kursinis.e12.Demo

SRCFILES_e13 := $(shell find $(SRCDIR)/e13 -type f -name "*.scala")
e13: ${SRCFILES_e13}
	scalac -unchecked -deprecation -d $(DESTDIR) $(SRCFILES_e13)
	scala -cp bin lt.astrauskas.kursinis.e13.Demo \
		src/lt/astrauskas/kursinis/e13/data.exmp

interactive:
	scala -cp bin

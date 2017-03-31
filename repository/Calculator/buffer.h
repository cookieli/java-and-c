#ifndef BUFFER_H_INCLUDED
#define BUFFER_H_INCLUDED
#define BUFSIZE 100
#define NUMBER '0'
#define NAME   'n'
extern char buf[BUFSIZE];
extern int bufp ;
int getch(void);
void ungetch(int c);
int getop(char s[]);
#endif // BUFFER_H_INCLUDED

#ifndef STACK_H_INCLUDED
#define STACK_H_INCLUDED
#define MAXVAL  100
extern int sp ; /*next position in stack */
extern double val[MAXVAL];
void push(double f);
double pop();
void clear(void);

#endif // STACK_H_INCLUDED

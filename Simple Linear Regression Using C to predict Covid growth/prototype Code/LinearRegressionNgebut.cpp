#include <stdio.h>
#include <math.h>

struct data
{
	int date[13][32];
}tahun[3000];

float xminusX[22],yminusY[22],x[22],y[22];

void dataSet();
int linearRegression(int year,int month,int date);
void fillGlobalArray(int currYear,int currMonth,int currDay);
void fillRemainingGlobalArray(float X,float Y);
float getSigmaY();
float getSigmaX();
float getSigmaCross();

int main(){
	dataSet();
	while(true){
		printf("Prototype Covid 19 Prediction - Oktober And July 2020 Version\n");
		printf("==========================================================\n");
		int day,month;
		printf("Enter month: ");
		scanf("%d",&month);
		printf("Enter day: ");
		scanf("%d",&day);
		int prediction = linearRegression(2020,month,day);
		printf("Prediction : %d\n\n",prediction);
	}
	
	return 0;
}

float averagePastInfected(int currYear,int currMonth,int currDay){
	float pastInfected=0;
	
	for(int i=1;i<=10;i++){
				if(i>=currDay){ //jika tanggal kurang dari 20 (bakal liat data bulan lalu) -- tahun lom bikin :)
					currMonth--;

					if(currMonth<7)
					{
						if(currMonth%2 == 1) currDay+=31;
						else currDay+=30;								
					}
					else if(currMonth>8)
					{	
						if(currMonth%2 == 1) currDay+=30;
						else currDay+=31;
					}
					else{
						currDay+=31;
					}
				}
				pastInfected += tahun[currYear].date[currMonth][currDay-i];
			}
			
	return pastInfected/10;
}

float averageLast20Date(int currYear,int currMonth,int currDay){
	
	float avg20day=0;
	
	for(int i=1;i<=10;i++){
		if(i>=currDay){ //jika tanggal kurang dari 20 (bakal liat data bulan lalu) -- tahun lom bikin :)
			currMonth--;

			if(currMonth<7)
			{
				if(currMonth%2 == 1) currDay+=31;
				else currDay+=30;								
			}
			else if(currMonth>8)
			{	
				if(currMonth%2 == 1) currDay+=30;
				else currDay+=31;
			}
			else{
				currDay+=31;
			}
		}
		avg20day += currDay-i;
	}
	
	return avg20day/10;
}

int linearRegression(int year,int month,int date){
	
	if(tahun[year].date[month][date-1] == NULL){
		tahun[year].date[month][date-1] = linearRegression(year,month,date-1);
	}
	
	float sigmaCross,sigmaX,sigmaY;
	
	fillGlobalArray(year,month,date);
	
	float X = averageLast20Date(year,month,date); 
	float Y = averagePastInfected(year,month,date);
	
	fillRemainingGlobalArray(X,Y);
	
	sigmaX = getSigmaX();
	sigmaY = getSigmaY();
	sigmaCross = getSigmaCross();
	
	float r = sigmaCross/sqrt(sigmaX*sigmaY);
	float Sy = sqrt(sigmaY/9); // dibagi n-1 (9 jadinya)
	float Sx = sqrt(sigmaX/9); // dibagi n-1 (9 jadinya)
	
	float b = r*Sy/Sx;
	float a = Y-b*X; 

	int y = a + b*date;
	
	return y;
}

void dataSet(){
	//oktober 2020
	tahun[2020].date[10][1] = 75521;
	tahun[2020].date[10][2] = 76619;
	tahun[2020].date[10][3] = 77784;
	tahun[2020].date[10][4] = 79214;
	tahun[2020].date[10][5] = 80036;
	tahun[2020].date[10][6] = 81043;
	tahun[2020].date[10][7] = 82383;
	tahun[2020].date[10][8] = 83392;
	tahun[2020].date[10][9] = 84364;
	tahun[2020].date[10][10] = 85617; 
	tahun[2020].date[10][11] = 87006;
	tahun[2020].date[10][12] = 88174;
	tahun[2020].date[10][13] = 89228;
	tahun[2020].date[10][14] = 90266;
	tahun[2020].date[10][15] = 91337;
	tahun[2020].date[10][16] = 92382;
	tahun[2020].date[10][17] = 93356;
	tahun[2020].date[10][18] = 94327;
	tahun[2020].date[10][19] = 95253;
	tahun[2020].date[10][20] = 96217;
	
	//juli 2020
	tahun[2020].date[7][1] = 11482;
	tahun[2020].date[7][2] = 11677;
	tahun[2020].date[7][3] = 11824;
	tahun[2020].date[7][4] = 12039;
	tahun[2020].date[7][5] = 12295;
	tahun[2020].date[7][6] = 12526;
	tahun[2020].date[7][7] = 12725;
	tahun[2020].date[7][8] = 13069;
	tahun[2020].date[7][9] = 13359;
	tahun[2020].date[7][10] = 13598;
	tahun[2020].date[7][11] = 13957;
	tahun[2020].date[7][12] = 14361;
	tahun[2020].date[7][13] = 14639;
	tahun[2020].date[7][14] = 14914;
	tahun[2020].date[7][15] = 15173;
	
}

void fillGlobalArray(int currYear,int currMonth,int currDay){
	int hari = 10;
	for(int i=1;i<=10;i++){
		if(i>=currDay){ //jika tanggal kurang dari 10 (bakal liat data bulan lalu) -- tahun lom bikin :)
			currMonth--;

			if(currMonth<7)
			{
				if(currMonth%2 == 1) currDay+=31;
				else currDay+=30;								
			}
			else if(currMonth>8)
			{	
				if(currMonth%2 == 1) currDay+=30;
				else currDay+=31;
			}
			else{
				currDay+=31;
			}
		}

		x[hari] = currDay-i;
		y[hari] = tahun[2020].date[currMonth][currDay-i];
	hari--;	
	}
	
}

void fillRemainingGlobalArray(float X,float Y){
	
	for(int i=1;i<=10;i++){
		xminusX[i] = x[i] - X;
		yminusY[i] = y[i] - Y;
	}
	
}

float getSigmaX(){
	
	float sigmaX=0;
	
	for(int i=1;i<=10;i++){
		sigmaX += (xminusX[i]*xminusX[i]); 
	}
	
	return sigmaX;
}

float getSigmaY(){
	
	float sigmaY=0;
	
	for(int i=1;i<=10;i++){
		sigmaY += (yminusY[i]*yminusY[i]); 
	}
	
	return sigmaY;
}

float getSigmaCross(){
	
	float sigmaCross=0;
	
	for(int i=1;i<=10;i++){
		sigmaCross += (xminusX[i]*yminusY[i]); 
	}
	
	return sigmaCross;
}





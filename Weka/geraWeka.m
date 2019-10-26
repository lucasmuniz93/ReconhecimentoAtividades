function geraWeka()
    NUMVOL = 8;
    format long;
    %format short      ponto fixo com 4 casas decimais (o padrão) 
    janela=2.5;
   % saida = fopen('deitado.arff', 'at');
    saida = fopen('andando.arff', 'at');
  %  saida = fopen('sentado.arff', 'at');
    geraCabecalho(saida);
    
  % nomeArquivos = {'deitado leve.txt'; 'deitado moderado.txt'; 'deitado vigoroso.txt'};
   nomeArquivos = {'andando leve.txt'; 'andando moderado.txt'; 'andando vigoroso.txt'};
  %  nomeArquivos = {'sentado leve.txt'; 'sentado moderado.txt'; 'sentado vigoroso.txt'};
    situacao = {'Leve'; 'Moderado'; 'Vigoroso'};

    
    
    for k=1:NUMVOL
    % Para todas as 9 

    for i=1:size(situacao,1)
        situacao(i)
        if k<10
            nomeArq = sprintf('0%d%s',k,char(nomeArquivos(i)));
        else
            nomeArq = sprintf('%d%s',k,char(nomeArquivos(i)));
        end
        dados = load(nomeArq);
        tempo=dados(:,4);
        tempoInicial=tempo(1);   %  <- estava tempo(i) mas deve ser 1.
        tempoInicial
        inicioJanela=1;
        for j=1:size(tempo,1)
            if ((tempo(j)-tempoInicial) > janela)
                geraExemplo(saida, situacao(i), dados(inicioJanela:j-1,1:3)); 
                tempoInicial = tempo(j);
                inicioJanela=j;
            end
        end 
        % Ultimos exemplos que não completaram uma janela de 2,5s - ou
        % descarta a sobra
        %if (inicioJanela~=j)  
        %   geraExemplo(saida, situacao(i), dados(inicioJanela:j,1:3));
        %end
    end
    end
    fclose(saida);
end

% Recebe como parâmetro as linhas de dados (x,y e z) para gerar um exemplo 
function geraExemplo(saida, situacao, dados)
    eixox=dados(:,1);
    eixoy=dados(:,2);
    eixoz=dados(:,3);
    %dados
    %pause;
       
%    exemplo = sprintf('%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c%f%c',mean(eixox),',',std(eixox),',',var(eixox),',',median(eixox),',',crms(eixox),',',mean(eixoy),',',std(eixoy),',',var(eixoy),',',median(eixoy),',',crms(eixoy),',',mean(eixoz),',',std(eixoz),',',var(eixoz),',',median(eixoz),',',crms(eixoz));
%     exemplo = sprintf('%f%c%f%c%f%c%f%c%f%c%f%c%f%',var(eixox),',',median(eixox),',',var(eixoy),',',median(eixoy),',',var(eixoz),',',median(eixoz),',',rms([eixox, eixoy, eixoz]));
 
%    exemplo = sprintf('%f%c%f%c%f%c%f%c%f%c%f',var(eixox),',',mean(eixox),',',var(eixoy),',',mean(eixoy),',',var(eixoz),',',mean(eixoz));
     
     exemplo = sprintf('%f%c%f%c%f%c%f%c%f%c%f',var(eixox),',',mean(eixox),',',var(eixoy),',',mean(eixoy),',',var(eixoz),',',mean(eixoz));

     
%exemplo = sprintf('%f',rms([eixox, eixoy, eixoz]));
    fprintf(saida,'%s,',exemplo);
    fprintf(saida,'%s',char(situacao));
    fprintf(saida,'\n');
end

function p = crms(eixo)
   total = 0;
   for z=1:size(eixo,1)
      total=total+eixo(z)*eixo(z);
   end
   total = total / size(eixo,1);
   p = sqrt(total);
end
 
 function geraCabecalho(saida)
    fprintf(saida,'@relation Andando\n');

    fprintf(saida,'\n\n');

%     fprintf(saida,'@attribute mediaX real\n');
%     fprintf(saida,'@attribute desvioPadraoX real\n');
%     fprintf(saida,'@attribute varianciaX real\n');
%     fprintf(saida,'@attribute medianaX real\n');
%     fprintf(saida,'@attribute rmsX real\n');
% 
%     fprintf(saida,'@attribute mediaY real\n');
%     fprintf(saida,'@attribute desvioPadraoY real\n');
%     fprintf(saida,'@attribute varianciaY real\n');
%     fprintf(saida,'@attribute medianaY real\n');
%     fprintf(saida,'@attribute rmsY real\n');
% 
%     fprintf(saida,'@attribute mediaZ real\n');
%     fprintf(saida,'@attribute desvioPadraoZ real\n');
%     fprintf(saida,'@attribute varianciaZ real\n');
%     fprintf(saida,'@attribute medianaZ real\n');
%     fprintf(saida,'@attribute rmsZ real\n');

    fprintf(saida,'@attribute varianciaX real\n');
    fprintf(saida,'@attribute mediaX real\n');

    fprintf(saida,'@attribute varianciaY real\n');
    fprintf(saida,'@attribute mediaY real\n');

    fprintf(saida,'@attribute varianciaZ real\n');
    fprintf(saida,'@attribute mediaZ real\n');
 %   fprintf(saida,'@attribute rms real\n');

    fprintf(saida,'@attribute categoria {Leve,Moderado,Vigoroso}\n');

    fprintf(saida,'\n\n');
    fprintf(saida,'@data\n');
 end


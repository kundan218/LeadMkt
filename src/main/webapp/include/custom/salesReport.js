var a=${dayAll};
var b=${regionArray};
var c=${saleArray};
var list='${list}';
var len='${list.size()}';
var arr=[];
var k=c[0];

for (var i = 0; i < len; i++) {
	var myArray = [];
	myArray.push(k[i].xaxis);
	myArray.push(k[i].yaxis);
	myArray.push(k[i].sale);
	arr.push(myArray);
}
//debugger
console.log(JSON.stringify(c));

Highcharts.chart('areaChart', {

    chart: {
        type: 'heatmap',
        marginTop: 40,
        marginBottom: 80,
        plotBorderWidth: 1
    },


    title: {
        text: ''
    },

    xAxis: {
        categories: b
    },

    yAxis: {
        categories: a,
        title: null
    },

    colorAxis: {
        min: 0,
        minColor: '#FFFFFF',
        maxColor: Highcharts.getOptions().colors[0]
    },

    legend: {
        align: 'right',
        layout: 'vertical',
        margin: 0,
        verticalAlign: 'top',
        y: 25,
        symbolHeight: 280
    },

    tooltip: {
        formatter: function () {
            return '<b> Total Lead </b> <br><b>' +
                this.point.value + '</b> tons to <b>' + this.series.xAxis.categories[this.point.x]+'</b> on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
        }
    },

    series: [{
        name: 'Sales per employee',
        borderWidth: 1,
        data: arr,
        dataLabels: {
            enabled: true,
            color: '#000000'
        }
    }]

});
var saleschart = Highcharts.chart('salesChart-d', {

    chart: {
        type: 'heatmap',
        marginTop: 40,
        marginBottom: 80,
        plotBorderWidth: 1
    },


    title: {
        text: 'My Sales In Last 7 Days'
    },

    xAxis: {
        categories: b
    },

    yAxis: {
        categories: a,
        title: null
    },

    colorAxis: {
        min: 0,
        minColor: '#FFFFFF',
        maxColor: Highcharts.getOptions().colors[0]
    },

    legend: {
        align: 'right',
        layout: 'vertical',
        margin: 0,
        verticalAlign: 'top',
        y: 25,
        symbolHeight: 280
    },

    tooltip: {
        formatter: function () {
            return '<b> Total Lead</b> <br><b>' +
            this.point.value + '</b> tons to <b>' + this.series.xAxis.categories[this.point.x]+'</b> on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
        }
    },
	plotOptions: {
	heatmap: {
        //stacking: 'normal',
        keys: ['x', 'y', 'value'],
        point: {
          events: {
            click: function() {
              alert(this.value);
			  $("#sales_chart_Pop .dataTable").show().animate({"height":"410px", "opacity":"1", "top":"0"});
            }
          }
        }
      },
	
      candlestick: {
         lineColor: '#404048'
      }
   },
	

    series: [{
	
	
	
        name: 'Sales per employee',
        borderWidth: 1,
		  
        data: arr,
        dataLabels: {
            enabled: true,
            color: '#000000'
        }
    }]
	
});


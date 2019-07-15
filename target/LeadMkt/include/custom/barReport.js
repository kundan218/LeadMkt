var barInvoice=${barInvoice};
var barMonth=${barMonth};
/*alert(barInvoice[6]);
alert(barMonth[6]);*/

/*var chart = Highcharts.chart('barChart', {

    title: {
        text: ''
    },

    subtitle: {
        text: ''
    },
	
  legend: {
        enabled: true
    },
    xAxis: {
        categories: barMonth
    },

    series: [{
        type: 'column',
        colorByPoint: true,
        data: barInvoice,
        showInLegend: false
    }]

});
*/

Highcharts.chart('barChart', {
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    subtitle: {
        text: ''
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: 'Sales in Tone'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
                format: '{point.y:.1f}'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px"></span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f} TON</b><br/>'
    },

    series: [{
        name: 'Brands',
        colorByPoint: true,
        data: [{
            name: barMonth[0],
            y: barInvoice[0]
        }, 
        {
            name: barMonth[1],
            y: barInvoice[1]
        }, 
        {
            name: barMonth[2],
            y: barInvoice[2]
        }, 
        {
            name: barMonth[3],
            y: barInvoice[3]
        }, 
        {
            name: barMonth[4],
            y: barInvoice[4]
        }, 
        {
            name: barMonth[5],
            y: barInvoice[5]
        }, 
        {
            name: barMonth[6],
            y: barInvoice[6]
        }, 
        {
            name: barMonth[7],
            y: barInvoice[7]
        }, 
        {
            name: barMonth[8],
            y: barInvoice[8]
        }, 
        {
            name: barMonth[9],
            y: barInvoice[9]
        }, 
        {
            name: barMonth[10],
            y: barInvoice[10]
        }, 
        {
            name: barMonth[11],
            y: barInvoice[11]
        }
        ]
    }],
    
});
Ap.calendar = Ap.calendar || {};

zk.afterMount(function() {

  let YEAR = 2015;
  let params = {};
  let selects = {};

  Ap.calendar.initHolidays = function () {

    function wrapper(id) {
      return $(`#ap-holidays-${id}-wrapper`);
    }

    function hide(id) {
      wrapper(id).hide();
    }

    function show(id) {
      wrapper(id).show();
    }

    function setupYear () {
      let options = [];
      for (let i = YEAR; i < YEAR + 10; i++) {
        options.push({
          id: i + "",
          title: i + ""
        });
      }
      populate('year', options, YEAR);
    }

    function genOptions(options) {
      if (!options) { return null; }
      return Object.keys(options).map(function (key) {
        return {
          id: key,
          title: options[key]
        }
      });
    }

    function populate (id, options, selected) {
      let select = selects[id];
      select.clearOptions();
      if (options) {
        select.addOption(options);
      }
      select.clear();
      selected = selected || null;
      params[id] = selected;
      select.addItem(selected);
    }

    function setupCountry (selected) {
      let hd = new Holidays();
      let options = hd.getCountries();
      options = genOptions(options);
      populate('country', options, selected);
    }

    const onChange = {
      country: function (selected) {
        params['country'] = selected;
        let hd = new Holidays();
        let options = hd.getStates(params.country);
        options = genOptions(options);
        populate('state', options);
        if (!options) {
          hide('state');
        } else {
          show('state');
        }
        hide('region');
      },
      state: function (selected) {
        params['state'] = selected;
        let hd = new Holidays();
        let options = hd.getRegions(params.country, params.state);
        options = genOptions(options);
        populate('region', options);
        if (!options) {
          hide('region');
        } else {
          show('region');
        }
      },
      region: function (selected) {
        params['region'] = selected;
      }
    };

    ['year', 'country', 'state', 'region'].forEach(function (id) {
      let $select =
          $('#' + id).selectize({
            valueField: 'id',
            labelField: 'title',
            searchField: 'title',
            dropdownParent: 'body',
            create: false,
            onChange: (function (id) {
              return function (selected) {
                if (onChange[id]) {
                  onChange[id](selected);
                }
              };
            })(id)
          });
      selects[id] = $select[0].selectize;
    });
    show('year');
    show('country');
    hide('state');
    hide('region');
    setupYear();
    setupCountry('AU');
  }

  Ap.calendar.submitHolidays = function () {
    let hd = new Holidays(params.country, params.state, params.region)
    let holidays = hd.getHolidays(params.year).map((holiday) => {
      return {
        date: holiday.date.substring(0, 10),
        name: holiday.name
      }
    });
    if (holidays) {
      zAu.send(new zk.Event(zk.Widget.$('$saveBtn'), 'onSubmit', holidays));
    }
  }

  Ap.calendar.initHolidays();

});